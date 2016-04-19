<?xml version="1.0" encoding="UTF-8" standalone="no"?>

<project basedir="." default="build" name="stringsearch" xmlns:jacoco="antlib:org.jacoco.ant">
  <property environment="env" />
  
  <property name="debuglevel" value="source,lines,vars" />
  <property name="target" value="1.7" />
  <property name="source" value="1.7" />
  
  <property name="src.dir" value="src" />
  <property name="test.dir" value="test" />	
  <property name="build.dir" value="build" />
  <property name="lib.dir" value="lib" />
  <property name="report.dir" value="reports" />
  <property name="test.report.dir" value="${report.dir}/test" />
  <property name="javadoc.report.dir" value="${report.dir}/javadoc" />
  <property name="coverage.report.dir" value="${report.dir}/coverage" />
  <property name="mutation.report.dir" value="${report.dir}/mutation" />
  
  <path id="junit.lib">
    <pathelement location="${lib.dir}/junit-4.12.jar" />
    <pathelement location="${lib.dir}/hamcrest-core-1.3.jar" />
  </path>
  
  <taskdef uri="antlib:org.jacoco.ant" resource="org/jacoco/ant/antlib.xml">
    <classpath path="${lib.dir}/jacocoant.jar" />
  </taskdef>
  
  <path id="pitest.lib">
    <path refid="junit.lib"/>
    <pathelement location="${lib.dir}/pitest-1.1.4.jar" />
    <pathelement location="${lib.dir}/pitest-ant-1.1.4.jar" />
  </path>
  
  <taskdef name="pitest" classname="org.pitest.ant.PitestTask" classpathref="pitest.lib" />
  
  <path id="build.src.path">
    <pathelement location="build" />
  </path>
  
  <path id="build.test.path">
    <path refid="build.src.path" />
    <path refid="junit.lib" />
  </path>
  
  <path id="test.path">
    <path refid="build.test.path" />
  </path>
  
  <path id="mutation.path">
    <path refid="test.path" />
    <path refid="pitest.lib" />
  </path>
  
  <target name="build" depends="build.src, build.test" description="build project and tests" />
  
  <target name="build.src">
    <mkdir dir="${build.dir}" />
    
    <copy includeemptydirs="false" todir="${build.dir}">
      <fileset dir="${src.dir}">
	<exclude name="**/*.java" />
      </fileset>
    </copy>
    
    <javac debug="true"
	   debuglevel="${debuglevel}"
	   destdir="${build.dir}"
	   includeantruntime="false">
      <src path="${src.dir}" />
      <classpath refid="build.src.path" />
    </javac>
  </target>
  
  <target name="build.test">
    <mkdir dir="${build.dir}" />
    
    <copy includeemptydirs="false" todir="${build.dir}">
      <fileset dir="${test.dir}">
	<exclude name="**/*.java" />
      </fileset>
    </copy>
    
    <javac debug="true"
	   debuglevel="${debuglevel}"
	   destdir="${build.dir}"
	   includeantruntime="false">
      <src path="${test.dir}" />
      <classpath>
	<path refid="build.test.path" />	
      </classpath>
    </javac>
  </target>
  
  <target name="javadoc" description="generate documentation">
    <javadoc sourcepath="${src.dir}" destdir="${javadoc.report.dir}" />
  </target>
  
  <target name="test" depends="build" description="run JUnit tests">
    <mkdir dir="${test.report.dir}" />
    
    <junit printsummary="yes" haltonfailure="no" fork="true" forkmode="once">
      <classpath refid="test.path" />
      
      <formatter type="xml" />
      
      <batchtest todir="${test.report.dir}">
	<fileset dir="${test.dir}">
	  <include name="**/*Test*.java" />
	</fileset>
      </batchtest>
    </junit>
    
    <junitreport todir="${test.report.dir}">
      
      <fileset dir="${test.report.dir}">
	<include name="TEST-*.xml" />
      </fileset>
      
      <report format="frames" todir="${test.report.dir}/html" />
    </junitreport>
  </target>
  
  <target name="coverage" depends="build" description="calculate code coverage">
    
    <mkdir dir="${test.report.dir}" />
    
    <jacoco:coverage>
      <junit printsummary="yes" haltonfailure="no" fork="true" forkmode="once">
	<classpath refid="test.path" />
	
	<batchtest todir="${test.report.dir}">
	  <fileset dir="${test.dir}">
	    <include name="**/*Test*.java" />
	  </fileset>
	</batchtest>
      </junit>
    </jacoco:coverage>
    
    <mkdir dir="${coverage.report.dir}" />
    <jacoco:report>
      <executiondata>
	<file file="jacoco.exec" />
      </executiondata>
      
      <structure name="${ant.project.name}">
	<classfiles>
	  <fileset dir="${build.dir}" casesensitive="yes">
	    <exclude name="**/*Test*" />
	  </fileset>
	</classfiles>
	
	<sourcefiles encoding="UTF-8">
	  <fileset dir="${src.dir}" />
	</sourcefiles>
      </structure>
      
      <html destdir="${coverage.report.dir}" />
    </jacoco:report>
    
    <delete file="jacoco.exec" />
    
  </target>
  
  
  <target name="mutation" depends="build" description="run mutation tests">
    <pitest pitClasspath="pitest.lib"
	    classPath="mutation.path"
	    targetClasses="com.eaio.stringsearch.*"
	    targetTests="com.eaio.stringsearch.*"
	    reportDir="${mutation.report.dir}"
	    sourceDir="${src.dir}" />
  </target>
  
  <target name="clean" description="clean project">
    <delete dir="${build.dir}" />
    <delete dir="${report.dir}" />
  </target>
  
</project>