
@import exercise.util.NamedRoutes
@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Training</title>
    </head>
    <body>
        @if(page != null && page.getFlash() != null)
            <p style="text-align: center; font-size: 20px;">${page.getFlash()}</p>
        @endif
        <div style="text-align: center; margin-top: 300px;">${content}</div>
    </body>
</html>
<!-- BEGIN -->
<!-- END -->
