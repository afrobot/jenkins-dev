#!/usr/bin/env groovy

productionRepo = 'git@github.com:afrobot/jenkins-prod.git'

stage 'build'
  node {
    //checkout scm
    checkout([
      $class:'GitSCM',
      branches: [[name: 'master']],
      userRemoteConfigs: [
        [credentialsId: 'github-afrobot', url: 'git@github.com:afrobot/jenkins-dev.git', 'production']
      ]])
    sshagent(['github-afrobot']) {
      sh """
        git fetch --all
        git show-ref
        git branch
        git diff origin/master
        git ls-remote
      """
    }
  }
