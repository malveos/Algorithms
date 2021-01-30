export const updateObject = (oldObject, updatedValues) => {
    return {
        ...oldObject,
        ...updatedValues
    }
};

export const checkValidity = (value, rules) => {
    let isValid = true;
    if (rules.required) {
        isValid = isValid && value.trim() !== '';
    }
    if (rules.minLength) {
        isValid = isValid && value.length >= rules.minLength;
    }
    if (rules.maxLength) {
        isValid = isValid && value.length <= rules.maxLength;
    }
    if(rules.isEmail) {
        const pattern = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        isValid = isValid && pattern.test(value);
    }
    return isValid;
};