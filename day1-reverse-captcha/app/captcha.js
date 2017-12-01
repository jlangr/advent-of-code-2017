const captcha = (numberText) => {
  const numberTextWithWrap = numberText.slice(0) + numberText[0];

  let matchingDigits = [];
  for (let i = 0; i < numberText.length; i++)
    if (numberText[i] === numberTextWithWrap[i + 1])
      matchingDigits.push(parseInt(numberText[i]));
  return matchingDigits.reduce((sum, digit) => sum + digit, 0);
};

export default captcha;