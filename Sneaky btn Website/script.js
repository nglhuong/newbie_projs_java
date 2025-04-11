document.addEventListener("DOMContentLoaded", () => {
    const button = document.querySelector("#sneaky-btn");

    const talkTrashQuotes = [
        "Ещё раз подумай",
        "Ты уверен?",
        "Ответ неверный",
        "У тебя жар",
        "Что за вздор?!",
        "Невозможно!",
        "Анджелина с тобой не согласна",
        "Передумай!",
        "Кто ты мне после этого?"
    ];

    // Ensure it starts at the correct position
    setInitialPosition(button);

    ["mouseover", "click"].forEach(function (type) {
        button.addEventListener(type, function (e) {
            const maxLeft = window.innerWidth - this.offsetWidth;
            const maxTop = window.innerHeight - this.offsetHeight;
            
            const top = getRandomNum(maxTop);
            const left = getRandomNum(maxLeft);

            moveElement(this, "left", left);
            moveElement(this, "top", top);

            const quote = getRandomQuote(talkTrashQuotes);
            if (quote) button.innerHTML = quote;
        });
    });

    const moveElement = (element, animeType, pixels) => {
        anime({
            targets: element,
            [animeType]: `${pixels}px`,
            easing: "easeOutElastic(1, .5)",
            duration: 750,
        }).play();
    };

    const getRandomNum = (num) => {
        return Math.floor(Math.random() * num);
    }

    const getRandomQuote = (quotes) => {
      const index = getRandomNum(quotes.length);
      return quotes[index];
    }

    // Function to set the initial position of the sneaky button
    function setInitialPosition(button) {
        const commonButton = document.getElementById("common-btn");
        const buttonContainer = document.querySelector(".button-container");

        // Calculate position relative to the button container
        const left = commonButton.offsetLeft + commonButton.offsetWidth + 20; // To the right of the common button
        const top = commonButton.offsetTop;

        button.style.position = 'absolute';
        button.style.left = `${left}px`;
        button.style.top = `${top}px`;
    }
});
