pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      parallel {
        stage('Upload Nexus') {
          agent {
            docker {
              image 'maven:3-alpine'
              args '-v /usr/share/conf_m2:/root/.m2:ro'
            }

          }
          steps {
            sh '''mvn -v
pwd
whoami
ls /root/.m2
uname -a'''
            sh '''ifconfig | grep "inet " | grep -v 127.0.0.1
ls /root/.m2
cat /root/.m2/copy_reference_file.log

mvn -v
uname -a
COPY /usr/share/conf_m2/settings.xml /usr/share/maven/ref/
mvn --settings /root/.m2/settings.xml clean deploy -f pom.xml'''
          }
        }
        stage('errores') {
          steps {
            catchError()
          }
        }
      }
    }
    stage('Borrar Workspace') {
      steps {
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanWhenNotBuilt: true, cleanWhenUnstable: true)
      }
    }
  }
  environment {
    maven = 'maven'
  }
}