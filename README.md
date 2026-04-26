# 异想工艺

## 目录

<!-- TOC -->

* [异想工艺](#异想工艺)
  * [目录](#目录)
  * [项目构建](#项目构建)
  * [开发人员(不分顺序)](#开发人员不分顺序)
  * [贡献者](#贡献者)
  * [本MOD前置](#本mod前置)

<!-- TOC -->

## 开发人员(不分顺序)

| 名称                                                        | 负责部分                                  |
|-----------------------------------------------------------|---------------------------------------|
| [哈基尽](https://space.bilibili.com/1082533225)              | 所有者/主程序/策划/动画/纹理<br/>（除了程序以外都不是主要进行的） |
| [尘昨喧](https://space.bilibili.com/161342683)               | 程序                                    |
| [ariwdxau](https://space.bilibili.com/3546886078204705)   | 程序                                    |
| [小史龙吖Slime_Dragon](https://space.bilibili.com/569400746)  | 主美                                    |
| [小希 Xiris/是Xiris哦](https://space.bilibili.com/1215603253) | 生物模型                                  |
| [星零大队长](https://space.bilibili.com/489185984)             | 部分物品纹理                                |
| [原木Log_ym](https://space.bilibili.com/138986403)          | 武器/盔甲/饰品模型                            |
| “老资历/人体派 学徒”?                                             | gui                                   |
| [天南野人](https://space.bilibili.com/2145067798)             | 武器/盔甲                                 |
| [Dashcode](https://space.bilibili.com/51204057)           | 动画                                    |
| "Macedonia"?                                              | 粒子                                    |

## 贡献者

| 名称                                                              | 内容          |
|-----------------------------------------------------------------|-------------|
| [FS-时叶](https://space.bilibili.com/3493109621066533)            | 客串          |
| [Zhu_Yii](https://space.bilibili.com/1209621490)                | 客串          |
| [-Yawning喵喵子-](https://space.bilibili.com/1446970336)           | 客串          |
| [一只霜狐Owo](https://space.bilibili.com/1214393496)                | 一些yes模型提供   |
| [Gstbnnnnnn/几点了啊啊](https://space.bilibili.com/3494357850130895) | 部分饰品/物品纹理提供 |
| [AmarokIce](https://space.bilibili.com/171428397)               | 程序          |
| “菜鸽子接动作动画”?                                                     | 玩家动画定制      |
| “宇宙之光”?                                                         | 程序          |

[//]: # (| “wdd”?                                                          | 程序 |)

[//]: # (| [永恒无虚]&#40;https://space.bilibili.com/1590922177&#41;                   | 美术        |)

[//]: # (| “倾城奶茶店店员”?                                                      | 模型        |)

[//]: # (| [涵_AH_han]&#40;https://space.bilibili.com/532826315&#41;                | 美术        |)

[//]: # (| [老旧的枕头与新毯子]&#40;https://space.bilibili.com/543764721&#41;               | 美术        |)

<hr>

## 本MOD前置

<p>
这些MOD链接都是github的但大部分在MCMOD百科或者其他MOD发布平台也有（搜名称）

| 前置链接及名称                                                       | 功能     |
|---------------------------------------------------------------|--------|
| [GeckoLib](https://github.com/bernie-g/geckolib)              | 基岩版模型库 |
| [Curios](https://github.com/TheIllusiveC4/Curios)             | 饰品     |
| [EpicFight](https://github.com/Antikythera-Studios/epicfight) | 史诗战斗   |

<hr>

联动MOD

| 名称                                      |
|-----------------------------------------|
| [玉 🔍](https://github.com/Snownee/Jade) |

## 项目构建

- 项目拉取完成后,确认子项目文件是否有拉取，如空文件夹请按下列指令在终端内顺序执行
  ~~~cmd
    git submodule init
    git submodule update
  ~~~

- 如果想要添加新的子模块，请使用以下指令
- 记得要在module文件夹中执行
  ~~~cmd
    git submodule add -b "仓库的分支名" "仓库的url" module/# 第 1 步: 回到项目根目录
cd D:\xm\mod\ArchitectureDepartment\ImaginaryCraft

# 第 2 步: 查看 .gitmodules 当前内容
cat .gitmodules

# 第 3 步: 从 Git 索引中移除 EGOCurios (如果存在)
git rm --cached module/EGOCurios -r -f --ignore-unmatch

# 第 4 步: 暂时移动 EGOCurios 目录(备份)
Move-Item -Path "module\EGOCurios" -Destination "D:\EGOCurios-backup"

# 第 5 步: 清理 .gitmodules 中的 EGOCurios 配置
git config -f .gitmodules --remove-section submodule.module/EGOCurios -f 2>$null

# 第 6 步: 清理 .git/config 中的配置
git config -f .git/config --remove-section submodule.module/EGOCurios -f 2>$null

# 第 7 步: 提交清理更改
git add .gitmodules
git commit -m "清理 EGOCurios 子模块配置"

# 第 8 步: 重新添加子模块
git submodule add -b main https://github.com/Architecture-Department/EGOCurios module/EGOCurios

# 第 9 步: 初始化子模块
git submodule update --init --recursive

# 第 10 步: 恢复之前备份的内容(如果需要)
# 注意: 这会覆盖子模块的原始内容,通常不需要
# Copy-Item -Path "D:\EGOCurios-backup\*" -Destination "module\EGOCurios\" -Recurse -Force

# 第 11 步: 提交
git add .gitmodules module/EGOCurios
git commit -m "重新添加 EGOCurios 子模块"

# 第 12 步: 清理备份
Remove-Item -Recurse -Force "D:\EGOCurios-backup" -ErrorAction SilentlyContinue

  ~~~
  > 还需要在[settings.gradle](settings.gradle)
  > 以及[ImaginaryCraft](module/ImaginaryCraft)/build.gradle]里加上子模块名

- 全部拉取完成后,在gradle插件中启动ImaginaryCraft本体项目中的runClient命令