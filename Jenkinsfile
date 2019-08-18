pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          agent any
          steps {
            echo 'Inicia Build'
            sh 'mvn --settings /var/jenkins_home/plugins/settings.xml clean deploy -f pom.xml'
            echo 'Fin Build'
          }
        }
        stage('Analisis SonarQube') {
          steps {
            sh '''mvn sonar:sonar \\
-Dsonar.host.url=http://190.160.136.181:9011 \\
-Dsonar.login=admin \\
-Dsonar.password=admin \\
-Dsonar.projectName=utilidades-snapshot \\
-Dsonar.projectVersion=1.0 \\
-Dsonar.projectKey=utilidades-snapshot \\
-Dsonar.sources=src \\
-Dsonar.java.binaries=\'target/classes/\' \\'''
          }
        }
      }
    }
    stage('Borrar Workspace') {
      steps {
        echo 'Inicio'
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenNotBuilt: true, cleanWhenSuccess: true, cleanWhenUnstable: true, cleanupMatrixParent: true)
        echo 'Fin'
      }
    }
  }
  tools {
    maven 'maven'
  }
}