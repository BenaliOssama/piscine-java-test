#!/bin/bash

# check if argument is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <directoryname>"
  exit 1
fi

DIR="$1"

# create directory and files
mkdir -p "$DIR"
touch "$DIR/$DIR.java" "$DIR/ExerciseRunner.java"

# copy script for running exercice
cp run.sh "$DIR/run.sh"

# go into directory
cd "$DIR" || { echo "Cannot enter directory $DIR"; exit 1; }

# open files in nvim
nvim "$DIR.java" "ExerciseRunner.java"
