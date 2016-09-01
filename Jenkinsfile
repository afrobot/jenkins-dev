#!/usr/bin/env groovy

devRepo = 'git@github.com:afrobot/jenkins-dev.git'
prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

node {
  stage("init") {
    checkout scm
  }

  stage("build") {
  }

  stage("tests") {
  }

  stage("sync-master") {
    // git remote add prod ...
    checkout([
      $class:'GitSCM',
      branches: [[name: 'master']],
      extensions: [[$class: 'WipeWorkspace']],
      userRemoteConfigs: [
        [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
      ]])
    // checkout again to correct sha1
    checkout scm

    sh 'git show-ref'
  }

}


// node {
//   stage 'checkout'
//     checkoutRepo(devRepo, prodRepo)
//     checkout scm
//
//   stage 'build'
//     sshagent(['github-afrobot']) {
//       sh """
//         git fetch --all
//         git show-ref
//         git ls-remote
//       """ }
//
// }



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

// def checkoutRepo(devRepo, prodRepo) {
//   checkout([
//     $class:'GitSCM',
//     branches: [[name: 'master']],
//     extensions: [[$class: 'WipeWorkspace']],
//     userRemoteConfigs: [
//       [credentialsId: 'github-afrobot', url: "${devRepo}",  name: 'origin'],
//       [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
//     ]])
// }
//
// class Utils {
//
// }



// usuwanie niepotrzebnych developerskich tagow:
// git tag | grep -v "^[0-9.]*$" | xargs git tag -d

// git fetch --all
// git show-ref
// git branch
// git diff origin/master
// git ls-remote
