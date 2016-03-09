#!/bin/bash
# This script builds all the snippet projects
set -eu

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

find "$SCRIPT_DIR" -maxdepth 1 -type d  -printf "%P\n" | sort | while IFS= read -r d; do
    if [[ "$d" && -e "$SCRIPT_DIR/$d/build.xml" ]]; then
        echo "== Building $d"
        (
            cd "$SCRIPT_DIR/$d"
            ant eclipse main &> "ant.log" || { echo "= Build has failed cat, log: "; cat "ant.log"; }
        )
    elif [[ "$d" ]]; then
        echo "== Directory does not contain a build.xml file: $d"
    fi
done

echo "== Done"
