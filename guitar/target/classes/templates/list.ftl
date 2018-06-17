<html>
<head>
    <title>
        guitar
    </title>
</head>
<body>
<form action="/findByName" method="post">
    根据名称查询：<input type="text" name = "name"> <input type="submit" value="查询">
</form>
<table>
    <thead>
    <th>序号</th>
    <th>名称</th>
    <th>价格</th>
    <th>材质</th>
    <th>颜色</th>
    <th>操作</th>
    </thead>
    <tbody>
        <#list guitars as guitar>
        <tr>
            <td>${guitar.id}</td>
            <td>${guitar.name}</td>
            <td>${guitar.price}</td>
            <td>${guitar.wood}</td>
            <td>${guitar.color}</td>
            <td><a href="/delete/${guitar.id}">删除</a></td>
        </tr>
        </#list>
    </tbody>
</table>

<form action="/add" method="post">
    <table>
        <thead>
        <th>名称</th>
        <th>价格</th>
        <th>材质</th>
        <th>颜色</th>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="price"></td>
            <td><input type="text" name="wood"></td>
            <td><input type="text" name="color"></td>
            <td><input type="submit" value="保存"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>