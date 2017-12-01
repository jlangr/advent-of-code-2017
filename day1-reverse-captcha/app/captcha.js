const matchesNext = (i, text) => {
  const halfway = text.length / 2;
  const next = (i + halfway) % text.length;
  return text[i] === text[next];
};

const captcha = (numberText) => {
  return numberText
    .split('')
    .filter((digitChar, i) => matchesNext(i, numberText))
    .reduce((sum, digitChar) => sum + parseInt(digitChar), 0);
};

export default captcha;