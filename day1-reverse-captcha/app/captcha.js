const matchesNext = (i, text) => {
  const next = (i === text.length - 1 ? 0 : i + 1);
  return text[i] === text[next];
};

const captcha = (numberText) => {
  return numberText
    .split('')
    .filter((digitChar, i) => matchesNext(i, numberText))
    .reduce((sum, digitChar) => sum + parseInt(digitChar), 0);
};

export default captcha;