const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');
const users = require('./users');

dotenv.config();

const app = express();
app.use(bodyParser.json());

app.use('/api/users', users);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
