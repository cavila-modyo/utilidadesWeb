pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      parallel {
        stage('Upload Nexus') {
          agent {
            docker {
              image 'maven:3-alpine'
              args '-v /root/.m2:/root/.m2'
            }

          }
          steps {
            sh '''ifconfig | grep "inet " | grep -v 127.0.0.1
ls /root/.m2
mvn -v
mvn --settings /usr/share/conf_m2/settings.xml clean deploy -f pom.xml'''
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
}