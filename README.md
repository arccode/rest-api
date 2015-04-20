# rest-api

 
[设计文档](http://arccode.net/2015/04/18/%E5%89%8D%E5%90%8E%E7%AB%AF%E5%AE%8C%E5%85%A8%E5%88%86%E7%A6%BB%E4%B9%8BAPI%E8%AE%BE%E8%AE%A1/)

## 开发部署

1. 从 GitHub 下载(采用 `git clone`方式, 或直接下载`zip`包)

		$ cd your-directory
        $ git clone https://github.com/arccode/rest-api

2. 将项目导入Java IDE, 笔者使用`IntelliJ IDEA`进行开发, 但项目是标准的`maven`结构, 相信大家均能正确导入.

3. 将项目部署至`tomcat`, 笔者习惯将其部署至根目录, 可以在`url`中少敲几个字符.

4. 打开浏览器, 输入`http://localhost:8080/index.html`可看到测试页面; 如果未更改部署目录的话, 那你访问的页面可能是`http://localhost:8080/rest-api/index.html`.

## 项目运行截图部分

![](http://arccode.net/images/arc/arc_add.png)

![](http://arccode.net/images/arc/arc_list.png)

![](http://arccode.net/images/arc/arc_exception.png)


## 支持

[联系方式](http://arccode.net/about/)