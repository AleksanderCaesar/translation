<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<div>
<div>
    <div>
        <form method="post">
        <div>
           Язык   текста
            <select name="fromLang" id="fromLang" >
                <#list fromLang as frLang>
                    <option>${frLang}</option>
                </#list>
            </select>

        </div>
        <div>
            Язык перевода
            <select name="toLang" id="toLang">
                <#list toLang as tlang>
                    <option>${tlang}</option>
                </#list>
            </select>

        </div>
    </div>
    <div>

        <div>
            <input type="text" name="textToTranslate" placeholder="Write you message">
        </div>
        <div>
            <button type="submit">Send</button>
        </div>
    </form>
</div>
<div>
  <#if traslations??>
      <#list traslations as traslation>
          <span>${traslation.text}</span>
      </#list>
  </#if>
</div>

</div>

</body>
</html>