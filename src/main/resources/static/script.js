async function calculate() {

    const num1 = document.getElementById("num1").value;
    const num2 = document.getElementById("num2").value;
    const operation = document.getElementById("operation").value;

   const response = await fetch(
    `/api/calculate?num1=${num1}&num2=${num2}&operation=${encodeURIComponent(operation)}`
);

    const result = await response.text();

    document.getElementById("result").innerText =
        "Result: " + result;
}