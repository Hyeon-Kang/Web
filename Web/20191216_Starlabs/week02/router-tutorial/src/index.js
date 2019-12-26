// 클라이언트는 기존의 App.js가 아닌 src/Client/Root.js 의 내용을 보게됨
import React from 'react';
import ReactDOM from 'react-dom';
import Root from './client/Root';
import * as serviceWorker from './serviceWorker';
import './index.css';

ReactDOM.render(<Root />, document.getElementById('root'));
serviceWorker.unregister();

