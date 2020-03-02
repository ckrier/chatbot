import React, { useState, useEffect } from "react";
import "./App.scss";

/* The features we want to add are
 * 1. Change the color of the message based on bot type
 * 2. Make the request to the server reference the bot type
 * 3. Add new Bot called reverse bot that reverses all the messages sent to it.
 */

const Message = props => {
  const { author, body } = props.data;

  return (
    <li className={"c-chat__item c-chat__item--" + author}>
      <div className="c-chat__message">{body}</div>
    </li>
  );
};

const Chat = () => {
  const [response, setResponse] = useState();

  // set up some initial messages
  const [messages, setMessages] = useState([
    {
      author: "bot",
      body: "Hello"
    },
    {
      author: "bot",
      body: "How are you?"
    }
  ]);

  useEffect(() => {
    if (response && response.message) {
      // make it look like our bot is at least trying to think
      setTimeout(
        () =>
          setMessages([
            ...messages,
            {
              author: "bot",
              body: response.message
            }
          ]),
        600
      );
    }
  }, [response]);

  const handleSubmit = e => {
    e.preventDefault();

    console.log(e.target.querySelector("input").value);
    setMessages([
      ...messages,
      {
        author: "human",
        body: e.target.querySelector("input").value
      }
    ]);

    getReply();

    e.target.reset();
  };

  const getReply = () => {
    fetch("http://localhost:8080/chat/glad", { mode: "cors" })
      .then(response => response.json())
      .then(data => {
        setResponse(data);
      });
  };

  return (
    <div className="b-chat">
      <div className="b-chat__container">
        <div id="chat">
          <div className="c-chat">
            <ul className="c-chat__list">
              {messages.map((message, index) => (
                <Message key={index} data={message} />
              ))}
            </ul>
            <form className="c-chat__form" onSubmit={handleSubmit}>
              <input
                type="text"
                name="input"
                placeholder="Type your message here..."
                autoFocus
                autoComplete="off"
                required
              />
            </form>
            <div className="button-container">
              <button className="button mad">Mad</button>
              <button className="button glad">Glad</button>
              <button className="button sad">Sad</button>
              <button className="button default">Default</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Chat;
