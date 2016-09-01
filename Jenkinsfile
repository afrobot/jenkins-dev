#!/usr/bin/env groovy

stage 'build'
  node {
    sshagent(['github-afrobot']) {
      sh """
        git fetch --all
        git show-ref
      """
    }
  }
