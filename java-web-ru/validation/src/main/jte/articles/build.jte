@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    <div style="text-align: center; height: 600px; overflow: auto;">

        @if(page.getErrors() != null)
            <ul style="color: red;">
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif

        <form action="/articles" method="post">
            <div>
                <label>
                    Название
                    <input type="text" name="title" value="${page.getTitle()}" />
                </label>
            </div>
            <div>
                <label>
                    Содержание
                </label>
                <textarea name="content">${page.getContent()}</textarea>
            </div>
            <input type="submit" value="Создать" />
        </form>
    </div>
`
)
