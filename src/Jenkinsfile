pipeline {
    agent any

    environment {
        IMAGE_NAME = 'java-backend-pipeline'
        IMAGE_TAG  = "${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling the latest code from Git...'
                checkout scm
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Executing JUnit & Mockito tests...'
                // If a test fails, the pipeline halts immediately.
                sh './mvnw clean test'
            }
        }

        stage('Package Application') {
            steps {
                echo 'Building the JAR file...'
                sh './mvnw package -DskipTests'
            }
        }

        stage('Docker Build & Tag') {
            steps {
                echo "Building Docker Image: ${IMAGE_NAME}:${IMAGE_TAG}"
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                sh "docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${IMAGE_NAME}:latest"
            }
        }
    }

    post {
        always {
            echo 'Cleaning up Jenkins workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the specific stage logs for details.'
        }
    }
}