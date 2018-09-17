package com.vogella.spring.first.di;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Todo implements ITodo {
	public final long id;
	private String summary;
	private boolean done;
	private Date dueDate;
	private String description;
	
	public Todo() {
		this(-1);
	}
	
	public Todo(long i) {
		this(i, "");
	}
	
	@Autowired
	public Todo(long i, @Qualifier("summary")String summary) {
		this.id = i;
		this.summary = summary;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getSummary() {
		return summary;
	}

	@Override
	public void setSummary(String summary) {
		this.summary = summary;

	}
	
    @Override
    public String getDescription() {
        return description;
    }

    @Autowired
    @Override
    @Qualifier("description")
    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public boolean isDone() {
		return done;
	}

	@Autowired
	@Override
	public void setDone(boolean isDone) {
		this.done = isDone;

	}

	@Override
	public Date getDueDate() {
		return dueDate;
	}

	@Autowired
	@Override
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result+(int)(id^(id >>>32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Todo other = (Todo)obj;
		if(id != other.id) return false;
		
		return true;	
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", summary=" + summary + ", description=" + description + "]";
	}
	

	@Override
	public Todo copy() {
	
		Todo todo = new Todo(id, summary);
		todo.setDone(this.isDone());
		todo.setDueDate(this.getDueDate());
		todo.setDescription(getDescription());
		return todo;
	}
}


/* Uma dependência é um objeto que a sua classe precisa para funcionar.
 * A dependência é injetada à classe que a utiliza.
 * Isso quer dizer que, para que haja uma injeção de dependência, a instanciação de um objeto não deve se dar dentro da classe, 
 * mas do lado de fora dela e então, injetada.
 * Na injeção de dependência você injeta o objeto (a dependência) na classe através 
 * de seu método construtor ou através de um método setter.
 * */

