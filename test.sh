#!/bin/bash

file_path='./index.html'

text_to_insert=$(ls -t ./ExtentReports/ | head -n 1)

line_number=23

column_position=35

# Create a temporary file to hold the modified content
tmp_file=$(mktemp)
trap 'rm -f "$tmp_file"' EXIT

# Use awk to insert text at the specified line and column position
awk -v line="$line_number" -v col="$column_position" -v text="$text_to_insert" '
  BEGIN {
    OFS=FS=""
  }
  NR == line {
    $col = text $col
  }
  { print > "'"$tmp_file"'" }
  ' "$file_path"

# Replace the original file with the modified content
mv "$tmp_file" "$file_path"