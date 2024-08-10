pipeline {
  agent any

  options {
    skipDefaultCheckout(true)
  }

  stages {
    stage('Prepare') {
      steps {
        checkout scm
        withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
          script {
            env.DOCKER_USER = env.DOCKER_USER
            env.DOCKER_PASSWORD = env.DOCKER_PASSWORD
            env.DOCKER_IMAGE = "${env.DOCKER_USER}/java-morse"
          }
        }            
      }
    }
    stage('Build Application') {
      steps {
        bat 'mvn clean package'
      }
    }
    stage('Build Docker Image') {
      steps {
        bat "docker build -t ${env.DOCKER_IMAGE} ."
      }
    }
    stage('Push Docker Image') {
      steps {
        bat "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASSWORD}"
        bat "docker push ${env.DOCKER_IMAGE}"
      }
    }
  }
  post {
    always {
      cleanWs()
      bat "docker rmi ${env.DOCKER_IMAGE}"
    }
  }  
}
