Concierge
=========

Concierge is a small-footprint implementation of the OSGi Core Specifications R3 standard optimized for mobile and embedded devices.

The following are the goals and plans for the Concierge project:

+ Bringing the framework to compliance with the current OSGi core R5 specifications by aggressively focusing on the new and future-proof features such as the generic requirement/capability model and thereby keeping the footprint small. The target is in the order of 300-400 kB Jar file size. Furthermore, the framework should not only run on current and upcoming Java embedded profiles (e.g., Java 8 compact profile) but it should also be possible to compile the code with the JSR-14 target to run it on legacy Java 1.4 VMs like CDC 1.1.
+ Keeping the source code compact and readable so that interested people have a realistic chance of understanding the internals of an OSGi framework.
+ Exploring new ways of integrating OSGi into mobile and embedded system stacks.
+ Being a sandbox for experimental features and optimizations for existing OSGi features that can be consumed by the Equinox project.
+ Providing a platform for exploratory research on how to bring the Java VM and the OSGi layer closer together to improve runtime performance.

The following are the non-goals:

+ It is not a goal to run the Eclipse IDE on Concierge any time soon.

Development Prerequisites

+ Java 1.7
+ Eclipse Kepler
+ Eclipse M2E