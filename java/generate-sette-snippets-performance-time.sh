#!/bin/bash
# This script re-generates the sette-snippets-performance-time project
set -eu

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
# Regular expression
SNIPPETS_TO_KEEP="(B2d_Linear|B2d_Nonlinear|B3a_While|_3_objects|_4_generics|_5_library)" 

error () {
    echo $2
    echo ==================================================
    exit $1
}

FROM="sette-snippets"
TO="sette-snippets-performance-time"

[ $# -eq 0 ] || error -1 "The script does not expect any parameter"

[ -d "$SCRIPT_DIR/$FROM" ] || error 1 "The original directory was not found: $SCRIPT_DIR/$FROM"


if [ -e "$SCRIPT_DIR/$TO" ]; then
    echo "The target directory already exists: $SCRIPT_DIR/$TO"
    backupTo="$TO-backup-$( date +"%Y-%m-%d_%H-%M-%S" )"
    mv "$SCRIPT_DIR/$TO" "$SCRIPT_DIR/$backupTo"
    echo "Backed up as $backupTo"
fi

echo "Copying original directory"
cp -r "$SCRIPT_DIR/$FROM" "$SCRIPT_DIR/$TO"

echo "Updating build.xml"
sed -b -i -r "s#<project(.*)name=\"$FROM\"#<project\1name=\"$TO\"#" "$SCRIPT_DIR/$TO/build.xml"

delete=(bin build .classpath .project)
for f in "${delete[@]}"; do
    echo "Deleting $f"
    rm -rf "$SCRIPT_DIR/$TO/$f"
done

srcDirs=(snippet-src snippet-input-src)
for src in "${srcDirs[@]}"; do
    find "$SCRIPT_DIR/$TO/$src" -type f -printf "%P\n" | grep -Ev "$SNIPPETS_TO_KEEP" | sort | while IFS= read -r f; do
        if [[ "$f" && -e "$SCRIPT_DIR/$TO/$src/$f" ]]; then
            echo "Deleting $src/$f"
            rm -rf "$SCRIPT_DIR/$TO/$src/$f"
        fi
    done

    find "$SCRIPT_DIR/$TO/$src" -type d -empty -delete
done

echo "Finished, do not forget to build the project"
