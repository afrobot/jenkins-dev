#!/usr/bin/env groovy

prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

stage 'checkout'
  node {
    git url: "${prodRepo}", credentialsId: 'github-afrobot', name: 'prod'
  }

// stage 'build'
//   node {
//     //checkout scm
//     sshagent(['github-afrobot']) {
//       git url: 'git@github.com:afrobot/jenkins-dev.git', credentialsId: 'github-afrobot', name: 'origin'
//
//       addRemoteRepo(prodRepo)
// 
//       sh """
//         git fetch --all
//         git show-ref
//         git branch
//         git diff origin/master
//         git ls-remote
//       """
//     }
//   }
//   }
//
def addRemoteRepo(prodRepo) {
  checkout([
    $class:'GitSCM',
    branches: [[name: 'master']],
    userRemoteConfigs: [
      [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
    ]])
}

// git fetch --all
// git show-ref
// git branch
// git diff origin/master
// git ls-remote
