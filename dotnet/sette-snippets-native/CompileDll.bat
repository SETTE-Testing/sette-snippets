SET VC=C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC

"%VC%/vcvarsall.bat" amd64_x86 && "%VC%/bin/amd64_x86/cl.exe" "N10.c" /MD /LD "/FeN10_x86.dll"
"%VC%/vcvarsall.bat" amd64 && "%VC%/bin/amd64/cl.exe" "N10.c" /MD /LD "/FeN10_x64.dll"
