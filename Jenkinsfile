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
            sh '''cp settings.xml /usr/share/maven/ref/
mvn --settings /usr/share/maven/ref/settings.xml clean deploy -f pom.xml'''
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