解释：Hanmin
为EDGE Mod 开发人员配置开发环境所写
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.
此代码为Minecraft Forge，会为您成功开发mod提供支持。
注意：此代码已实现一个TestMod，请确认能成功编译后再进行branch out/commit/push。

Setup Process:
安装过程：
==============================

第一步：使用git clone main branch。推荐在IDE中clone，为管理branch提供便利。有经验者可使用cmd/terminal/shell
file -> import -> git -> 'Projects from git' -> 'Clone URL' -> clone https://github.com/dlharry/TestMod.git。
第二步： 设置gradle
Run the following command: `gradlew genEclipseRuns` (`./gradlew genEclipseRuns` if you are on Mac/Linux)
运行以下指令： `gradlew genEclipseRuns` (若您为Mac/Linux用户 `./gradlew genEclipseRuns`)
Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run `gradlew eclipse` to generate the project.
第三步：
若遇到库缺失或其他问题，尝试`gradlew --refresh-dependencies` `gradlew clean`并重复第二步


Mapping Names:
=============================
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license, if you do not agree with it you can change your mapping names to other crowdsourced names in your 
build.gradle. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

Additional Resources: 
=========================
Community Documentation: https://mcforge.readthedocs.io/en/latest/gettingstarted/  
LexManos' Install Video: https://www.youtube.com/watch?v=8VEdtQLuLO0  
Forge Forum: https://forums.minecraftforge.net/  
Forge Discord: https://discord.gg/UvedJ9m  


##Haitian Setup Done
##Chenshun Setup Done
