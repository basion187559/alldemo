#!bin/bash
array=(
  docker.io/bitnami/etcd:3.5.4-debian-11-r14
)
TARGET=deploy.deepexi.com/cloud
for element in ${array[@]}
do
  echo source: $element
  docker pull $element
  arr=(`echo $element | tr '/' ' '`)
  lastIndex=$((${#arr[@]}-1))
  echo target: $TARGET/${arr[lastIndex]}
  docker tag $element $TARGET/${arr[lastIndex]}
  docker push $TARGET/${arr[lastIndex]}
done