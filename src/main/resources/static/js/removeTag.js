const tagList = document.querySelector('.tagList')

tagList.addEventListener('click', removeTag)

function removeTag(event) {
    if(event.target.classList.contains('delete')) {
        const deleteButton= event.target
        const tagContainer= deleteButton.parentElement

        const hrefArray = tagContainer.querySelector('a').getAttribute('href').split("/")
        const tagId = hrefArray[2]

        const xhr= new XMLHttpRequest()
        xhr.onreadystatechange = function(response) {
            if (xhr.readyState == 4 && xhr.status == 200) {
                const remainingTags = JSON.parse(response.currentTarget.response);
                let list = ''
                remaingTags.forEach(function(tag) {
                    list += `
                        <li>
                        <a href="/reviews/${id}/tags/${tag.id}">
                            ${tag.name}
                        </a>
                        <button class="delete">Remove</button>
                        </li>
                    `
                })
                tagList.innerHTML= list
            }
        }

        xhr.open("DELETE", `api/reviews/{id}/tags?id=${tagId}`, true)
        xhr.send()
    }
}