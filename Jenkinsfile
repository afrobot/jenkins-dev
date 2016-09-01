#!/usr/bin/env groovy

stage 'build'
  node {
    checkout scm

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
