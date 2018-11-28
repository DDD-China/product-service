#!/usr/bin/env bash

set -e

echo "===Copy kube deployment file==="
scp -o "StrictHostKeyChecking no" product-service-kube.yaml ubuntu@ec2-54-223-95-220.cn-north-1.compute.amazonaws.com.cn:/tmp/product-service-kube.yaml


echo "===SSH into node and pull image==="
ssh -o "StrictHostKeyChecking no" ubuntu@ec2-54-223-42-142.cn-north-1.compute.amazonaws.com.cn '
set -e
export REPO_NAME=product-service
export AWS_ECR_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn
docker pull $AWS_ECR_REGISTRY/$REPO_NAME:$1

ssh -o "StrictHostKeyChecking no" ubuntu@ec2-52-80-62-221.cn-north-1.compute.amazonaws.com.cn '
set -e
export REPO_NAME=product-service
export AWS_ECR_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn
docker pull $AWS_ECR_REGISTRY/$REPO_NAME:$1

echo "===SSH into cluster==="
ssh -o "StrictHostKeyChecking no" ubuntu@ec2-54-223-95-220.cn-north-1.compute.amazonaws.com.cn '
set -e
echo "===Deploy service and app==="
kubectl apply -f /tmp/product-service-kube.yaml
'
