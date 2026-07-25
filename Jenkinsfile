pipeline {
    agent any

    environment {
        IMAGE_NAME = 'handson-cicd-pipeline'
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
                // Using 'bat' and 'mvnw.cmd' for Windows Jenkins
                bat 'mvnw.cmd clean test'
            }
        }

        stage('Docker Build & Tag') {
            steps {
                echo "Building Docker Image: ${IMAGE_NAME}:${IMAGE_TAG}"
                // Using 'bat' instead of 'sh'
                bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                bat "docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${IMAGE_NAME}:latest"
            }
        }
    }

    post {
        always {
            echo 'Cleaning up Jenkins workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully! Docker image is ready.'
        }
        failure {
            echo 'Pipeline failed. Check the specific stage logs for details.'
        }
    }
}