#!/usr/bin/env groovy

ws {
  devRepo = 'git@github.com:afrobot/jenkins-dev.git'
  prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

  stage 'build'
    node {
      //checkout scm
      sshagent(['github-afrobot']) {
        git url: 'git@github.com:afrobot/jenkins-dev.git', credentialsId: 'github-afrobot', name: 'origin'

        addRemoteRepo(prodRepo)

        sh """
          git fetch --all
          git show-ref
          git branch
          git diff origin/master
          git ls-remote
        """
      }
    }
}

def addRemoteRepo(prodRepo) {
  checkout([
    $class:'GitSCM',
    branches: [[name: 'master']],
    userRemoteConfigs: [
      [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
    ]])
}
