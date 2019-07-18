pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v $HOME/.m2:/root/.m2:z -u root'
        }

      }
      steps {
        sh '''cp settings.xml /usr/share/maven/ref/
mvn --settings /usr/share/maven/ref/settings.xml clean deploy -f pom.xml'''
      }
    }
    stage('Borrar Workspace') {
      steps {
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanWhenNotBuilt: true, cleanWhenUnstable: true)
      }
    }
  }
}