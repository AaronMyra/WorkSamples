# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/student/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/183.4886.39/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/student/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/183.4886.39/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/student/CLionProjects/PROG2007-C/Assignment_4

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Assignment_4.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Assignment_4.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Assignment_4.dir/flags.make

CMakeFiles/Assignment_4.dir/main.c.o: CMakeFiles/Assignment_4.dir/flags.make
CMakeFiles/Assignment_4.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Assignment_4.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Assignment_4.dir/main.c.o   -c /home/student/CLionProjects/PROG2007-C/Assignment_4/main.c

CMakeFiles/Assignment_4.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Assignment_4.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/student/CLionProjects/PROG2007-C/Assignment_4/main.c > CMakeFiles/Assignment_4.dir/main.c.i

CMakeFiles/Assignment_4.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Assignment_4.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/student/CLionProjects/PROG2007-C/Assignment_4/main.c -o CMakeFiles/Assignment_4.dir/main.c.s

CMakeFiles/Assignment_4.dir/clearBuffer.c.o: CMakeFiles/Assignment_4.dir/flags.make
CMakeFiles/Assignment_4.dir/clearBuffer.c.o: ../clearBuffer.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/Assignment_4.dir/clearBuffer.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Assignment_4.dir/clearBuffer.c.o   -c /home/student/CLionProjects/PROG2007-C/Assignment_4/clearBuffer.c

CMakeFiles/Assignment_4.dir/clearBuffer.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Assignment_4.dir/clearBuffer.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/student/CLionProjects/PROG2007-C/Assignment_4/clearBuffer.c > CMakeFiles/Assignment_4.dir/clearBuffer.c.i

CMakeFiles/Assignment_4.dir/clearBuffer.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Assignment_4.dir/clearBuffer.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/student/CLionProjects/PROG2007-C/Assignment_4/clearBuffer.c -o CMakeFiles/Assignment_4.dir/clearBuffer.c.s

# Object files for target Assignment_4
Assignment_4_OBJECTS = \
"CMakeFiles/Assignment_4.dir/main.c.o" \
"CMakeFiles/Assignment_4.dir/clearBuffer.c.o"

# External object files for target Assignment_4
Assignment_4_EXTERNAL_OBJECTS =

Assignment_4: CMakeFiles/Assignment_4.dir/main.c.o
Assignment_4: CMakeFiles/Assignment_4.dir/clearBuffer.c.o
Assignment_4: CMakeFiles/Assignment_4.dir/build.make
Assignment_4: CMakeFiles/Assignment_4.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable Assignment_4"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Assignment_4.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Assignment_4.dir/build: Assignment_4

.PHONY : CMakeFiles/Assignment_4.dir/build

CMakeFiles/Assignment_4.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Assignment_4.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Assignment_4.dir/clean

CMakeFiles/Assignment_4.dir/depend:
	cd /home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/student/CLionProjects/PROG2007-C/Assignment_4 /home/student/CLionProjects/PROG2007-C/Assignment_4 /home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug /home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug /home/student/CLionProjects/PROG2007-C/Assignment_4/cmake-build-debug/CMakeFiles/Assignment_4.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Assignment_4.dir/depend

