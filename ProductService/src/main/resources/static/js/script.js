function getTotalPrice(element) {
    let id = element.id;
    let pricePerItem = 0;
    let count = 0;
    pricePerItem = document.getElementById(id + 'price').innerText;
    count = document.getElementById(id).value;
    return (pricePerItem * count).toFixed(2);
}

function setTotalPrice(element) {
    let id = element.id;
    document.getElementById(id + 'total_price').innerText = getTotalPrice(element);
    document.getElementsByClassName(id + 'localStorage_class').item(0).style.background = '#ff4040';
}

function addElementToLocalStorage(element) {
    let id = element.id;
    let count = 0;
    count = document.getElementsByClassName(id + 'count_class').item(0).value;
    localStorage.setItem(id, count);
    changeButtonColorAfterPuttingInLocalStorage(element)
}

function removeElementFromLocalStorage(element) {
    let id = element.id;
    localStorage.removeItem(id);
    location.reload();
}

function changeButtonColorAfterPuttingInLocalStorage(element) {
    let id = element.id;
    document.getElementsByClassName(id + 'localStorage_class').item(0).style.background = '#7eff5e';
}

function clearLocalStorage() {
    localStorage.clear();
    location.reload();
}

function fillTable() {
    for (let key in localStorage) {
        let countElement = document.getElementsByClassName(key + 'count_class').item(0);
        if (countElement != null) {
            let localStorageButton = document.getElementsByClassName(key + 'localStorage_class').item(0);
            let totalPrice = document.getElementById(key + 'total_price');
            let pricePerItem = document.getElementById(key + 'price').innerText;

            countElement.value = localStorage.getItem(key);
            localStorageButton.style.background = '#7eff5e';
            totalPrice.innerText = (parseFloat(pricePerItem) * countElement.value).toFixed(2);
        }
    }
}