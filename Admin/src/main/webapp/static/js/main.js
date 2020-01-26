window.addEventListener('load', () => {

    document.getElementById("table").addEventListener('click', function (event) {
        let target = event.target;

        if (target.name === 'edit') {

            let text = document.createTextNode('Редактирование преподавателя: ' + target.parentElement.parentElement.firstElementChild.nextElementSibling.textContent);///name
            let info = document.getElementById("info");

            if (info.firstChild !== null) {
                info.replaceChild(text, info.firstChild);
            } else {
                info.appendChild(text);
            }
            let form = document.getElementById('edit');

            form.firstElementChild.nextElementSibling.value =
                target.parentElement.parentElement.firstElementChild.textContent;//id


                    document.getElementById("nameF").value =target.parentElement.parentElement
                        .firstElementChild.nextElementSibling.textContent;//name

                        document.getElementById("phoneF").value =target.parentElement.parentElement
                            .firstElementChild.nextElementSibling.nextElementSibling.textContent;//phone

                            animate('table', 0, 'none');
            animate('edit', 1, 'block');

        } else if (target.name === 'delete') {

            let form = document.getElementById('delete');
            form.firstElementChild.value = target.parentElement.parentElement.firstElementChild.textContent;//id
            form.submit();
        }
    });

    function animate(id, opacity, display) {
        let el = document.getElementById(id);
        $(el).animate({opacity: opacity,}, 1000);
        el.style.display = display;
    }

});