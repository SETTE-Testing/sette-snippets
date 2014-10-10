#!/bin/bash
# This script builds our snippets for SETTE.

CWD="$(
  cd "$(dirname "$(readlink "$0" || printf %s "$0")")"
  pwd -P 
)"

ant -f "$CWD/sette-snippets-external/build.xml"
