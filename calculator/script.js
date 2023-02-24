let string = "";
let buttons = document.querySelectorAll('.button');
let currentVal = 0;
Array.from(buttons).forEach((button) => {
  button.addEventListener('click', (e) => {
    if (e.target.innerHTML == '=') {
      string = eval(string);
      document.querySelector('input').value = string;
    }
    else if (e.target.innerHTML == 'SQ') {
      string = eval(string);
      currentVal = string;
      currentVal = currentVal * string;
      document.querySelector('input').value = currentVal;
    }
    else if (e.target.innerHTML == 'SQRT') {
      string = eval(string);
      currentVal = Math.sqrt(string);
      document.querySelector('input').value = currentVal;
    }
    else if (e.target.innerHTML == 'C') {
      string = ""
      document.querySelector('input').value = string;
    }
    else {
      console.log(e.target)
      string = string + e.target.innerHTML;
      document.querySelector('input').value = string;
    }
  })
})