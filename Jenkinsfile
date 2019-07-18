pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      parallel {
        stage('Upload Nexus') {
          agent {
            docker {
              image 'maven:3-alpine'
              args '-v /usr/share/conf_m2:/root/.m2:ro --network atc'
            }

          }
          steps {
            sh '''mvn -v
pwd
whoami
ls /root/.m2
ls /usr/share/maven/ref/
'''
            sh '''
mvn -v

cd /var/jenkins_home/workspace/uploadNexus3_2
ls

ls /usr/share/maven/ref/
cp /usr/share/maven/ref/settings.xml /root/.m2/settings.xml
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
}