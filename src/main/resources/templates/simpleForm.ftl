<!doctype html>
<html lang="zh-CN">
<head class="v_scrollbar">
    <meta charset="UTF-8"/>
    <title>Simple Form</title>
    <style>
        html.v_scrollbar {
            overflow-y: scroll;
        }
        html {
            height: 100%;
            font-size: 100%;
        }
        /*body {
            line-height: 1.42857143;
            color: #333;
            background-color: #fff;
        }*/


        body {
            font-size: 14px;
            min-width: initial;
            background: none repeat scroll 0 0 #fff;
            color: #000;
            font-family: "Microsoft YaHei",WenQuanYi Micro Hei,"Heiti SC","Lucida Sans Unicode","Myriad Pro","Hiragino Sans GB",Verdana,simsun;
            font-size: 13px;
            min-height: 100%;
            min-width: 1080px;
            position: relative;
            margin: 0px;
        }

        .container {
            width: 90%;
            max-width: 1170px;
            margin-left: auto;
            margin-right: auto;
        }

        .main{
            background: none repeat scroll 0 0 #fff;
            border-radius: 0;
            padding: 30px;
            position: relative;
            border: 1px solid #e3e3e3;
            box-sizing: border-box;
            margin-bottom: 30px;
            text-shadow: 0 1px 0 #fff;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: inline-block;
            max-width: 100%;
            margin-bottom: 5px;
            font-weight: 700;
        }

        button, input, optgroup, select, textarea {
            margin: 0;
            font: inherit;
            color: inherit;
        }
        input {
            line-height: normal;
        }
        button, input, select, textarea {
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
        }
        .form-control {
            display: block;
            width: 100%;
            height: 34px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.42857143;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }

        p {
            margin: 0 0 10px;
        }
        .help-block {
            display: block;
            margin-top: 5px;
            margin-bottom: 10px;
            color: #737373;
        }


        .checkbox, .radio {
            position: relative;
            display: block;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        button, input, optgroup, select, textarea {
            margin: 0;
            font: inherit;
            color: inherit;
        }
        button {
            overflow: visible;
        }
        button, select {
            text-transform: none;
        }
        button, html input[type=button], input[type=reset], input[type=submit] {
            -webkit-appearance: button;
            cursor: pointer;
        }
        button, input, select, textarea {
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
        }
        .btn {
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }
        .btn-default {
            color: #333;
            background-color: #fff;
            border-color: #ccc;
        }

        /*table*/
        table {
            border-spacing: 0;
            border-collapse: collapse;
        }
        table {
            background-color: transparent;
        }
        .table {
            width: 100%;
            max-width: 100%;
            margin-bottom: 20px;
        }
        caption {
            display: table-caption;
            text-align: -webkit-center;
        }

        td, th {
            padding: 0;
        }
        th {
            text-align: left;
        }
        .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
            padding: 8px;
            line-height: 1.42857143;
            vertical-align: top;
            border-top: 1px solid #ddd;
        }
        .table>thead>tr>th {
            vertical-align: bottom;
            border-bottom: 2px solid #ddd;
        }
        .table>caption+thead>tr:first-child>td, .table>caption+thead>tr:first-child>th, .table>colgroup+thead>tr:first-child>td, .table>colgroup+thead>tr:first-child>th, .table>thead:first-child>tr:first-child>td, .table>thead:first-child>tr:first-child>th {
            border-top: 0;
        }

        .simple-form .form-group label{
            float:left;
            width: 80px;
        }
        .simple-form .form-group span.content-line{
            display: block;
            margin-left: 80px;
            width: 300px;
            border-bottom: 1px solid #444;
            border-radius: 3px;
            text-align: center;
        }
        .content-line.underline{
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="main">
        <div class="form-table">
            <form class="simple-form">
            <#if mode == "pdf"><#global lineStyle="underline"/></#if>
                <div class="form-group">
                    <label for="exampleInputMobile">手机号</label>
                    <span class="content-line ${lineStyle?default("")}">&nbsp;&nbsp;&nbsp;${mobile}&nbsp;&nbsp;&nbsp;</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">电子邮件</label>
                    <span class="content-line ${lineStyle?default("")}">&nbsp;&nbsp;&nbsp;${email}&nbsp;&nbsp;&nbsp;</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputName">姓名</label>
                    <span class="content-line ${lineStyle?default("")}">&nbsp;&nbsp;&nbsp;${name}&nbsp;&nbsp;&nbsp;</span>
                </div>
            </form>
        </div>
        <br/>
        <hr/>
        <br/>
        <div class="form-table">
            <table class="table">
                <caption>购物清单</caption>
                <thead>
                <tr>
                    <th>#</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>数量</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>西瓜</td>
                    <td>12</td>
                    <td>4</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>方便面</td>
                    <td>2</td>
                    <td>10</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>奶茶</td>
                    <td>10</td>
                    <td>2</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>