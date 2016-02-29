package com.dhtmlx.demo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class EventsManager extends DHXEventsManager {

	public EventsManager(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	 public Iterable<DHXEv> getEvents() {
         DHXEventsManager.date_format = "yyyy-MM-dd HH:mm:ss";
         List<DHXEv> evs = new ArrayList<DHXEv>();
         try {
                       java.sql.Connection conn = DatabaseConnection.getConnection();
  java.sql.Statement statement = conn.createStatement();

  String query = "SELECT event_id, event_name, start_date, end_date FROM events";
  ResultSet resultset = (ResultSet) statement.executeQuery(query);

  while (resultset.next()) {
     DHXEvent e = new DHXEvent();
     e.setId(Integer.parseInt(resultset.getString("event_id")));
     e.setText(resultset.getString("event_name"));
     e.setStart_date(resultset.getString("start_date"));
     e.setEnd_date(resultset.getString("end_date"));
     evs.add(e);
  }
  conn.close();
         } catch (SQLException e1) {
                       e1.printStackTrace();
         }
         DHXEventsManager.date_format = "MM/dd/yyyy HH:mm";

         return evs;
}

@Override
public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
         java.sql.Connection conn = DatabaseConnection.getConnection();
         java.sql.PreparedStatement ps = null;
         java.sql.ResultSet result = null;
         try {
                       String query = null;
                       String start_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(event.getStart_date());
                       String end_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(event.getEnd_date());
                       if (status == DHXStatus.UPDATE) {
                                      query = "UPDATE events SET event_name=?, start_date=?, end_date=? WHERE event_id=?";
                                      ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                                      ps.setString(1, event.getText());
                                      ps.setString(2, start_date);
                                      ps.setString(3, end_date);
                                      ps.setInt(4, event.getId());

                       } else if (status == DHXStatus.INSERT) {
                                      query = "INSERT INTO events (event_id, event_name, start_date, end_date) VALUES (null, ?, ?, ?)";
                                      ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                                      ps.setString(1, event.getText());
                                      ps.setString(2, start_date);
                                      ps.setString(3, end_date);

                       } else if (status == DHXStatus.DELETE) {
                                      query = "DELETE FROM events WHERE event_id=? LIMIT 1";
                                      ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                                      ps.setInt(1, event.getId());
                       }

                       if (ps!=null) {
                                      ps.executeUpdate();
                                      result = ps.getGeneratedKeys();
                                      if (result.next()) {
                                                     event.setId(result.getInt(1));
                                      }
                       }

         } catch (SQLException e) {
                       e.printStackTrace();
         } finally {
  if (result != null) try { result.close(); } catch (SQLException e) {}
  if (ps != null) try { ps.close(); } catch (SQLException e) {}
  if (conn != null) try { conn.close(); } catch (SQLException e) {}
}

         return status;
}

@Override
public DHXEv createEvent(String id, DHXStatus status) {
         return new DHXEvent();
}
}
