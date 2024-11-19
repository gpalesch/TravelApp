const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

const router = express.Router();

const usersDB = [];

function authenticateToken(req, res, next) {
    const token = req.headers['authorization'];
    if (!token) return res.status(401).send('Access Denied');

    jwt.verify(token, process.env.JWT_SECRET, (err, user) => {
        if (err) return res.status(403).send('Invalid Token');
        req.user = user;
        next();
    });
}

router.post('/register', async (req, res) => {
    const { username, password } = req.body;

    const userExists = usersDB.find(user => user.username === username);
    if (userExists) return res.status(400).send('User already exists');

    const hashedPassword = await bcrypt.hash(password, 10);

    const user = { username, password: hashedPassword };
    usersDB.push(user);

    res.status(201).send('User registered successfully');
});

router.post('/login', async (req, res) => {
    const { username, password } = req.body;

    const user = usersDB.find(user => user.username === username);
    if (!user) return res.status(400).send('User not found');

    const validPassword = await bcrypt.compare(password, user.password);
    if (!validPassword) return res.status(400).send('Invalid credentials');

    const token = jwt.sign({ username: user.username }, process.env.JWT_SECRET, {
        expiresIn: process.env.JWT_EXPIRES_IN
    });

    res.status(200).json({ token });
});

router.get('/protected', authenticateToken, (req, res) => {
    res.status(200).send(`Hello ${req.user.username}, welcome to the protected route!`);
});

module.exports = router;
