


# 边栏切换显示快捷键
`cmd K, B` 


# 设置字体
```css
"font_face": "Fira Code",
"font_options":
[
    "subpixel_antialias"
],
```


# Package Control 不是 Sublime text 自带的。
1. 打开命令面板: cmd + shift + P
2. 输入： Install Package Control

# 不行，还是得手动
1. Preferences > Browse Packages
2. 跳转到上级目录，有一个 Installed Packages
3. 下载 Package `Control.sublime-Package`
4. 复制到 Installed Packages 里面。
OK, 可以用了。

# 安装插件
1. 打开命令面板: cmd + shift + P
2. 输入: Package Control：Install Package
3. 输入要安装的包名。

## MarkdownPreview 设置好自动刷新
```
{
    "enable_autoreload": true,
}
```
## MarkdownEditing 高亮显示

## MarkdownEditing 背景显示

Preferences -> Package Settings -> Markdown Editting ->  Markdow GFM Settings - Default & Markdow GFM Settings - User ，将 Markdow GFM Settings - Default 中的内容拷贝至 Markdow GFM Settings - User 并保存，在 - User 中修改。

```
 "color_scheme": "Packages/Color Scheme - Default/Monokai.tmTheme",
```



## LiveReload：Enable ... Simple Reload
插件：
MarkdownPreview: markdown 预览， 转 html等。
LiveReload: 实时刷新。
