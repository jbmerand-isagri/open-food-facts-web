package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.utils.ConnectionUtils;

/**
 * Dao gérant les marques
 * 
 * @author Kevin.s
 *
 */
public class MarqueDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(MarqueDao.class);

	/**
	 * Constructeur
	 * 
	 */
	public MarqueDao() {
		super();
	}

	/**
	 * Ajoute toutes les marques dans la base de données
	 * 
	 * @param listeMarque hashSet des marques
	 */
	public void ajouterAllMarque(HashSet<String> listeMarque) {

		PreparedStatement insertMarque = null;
		try {
			insertMarque = ConnectionUtils.getInstance().prepareStatement("insert into marque (MRQ_NOM) values (?)");
			for (String marque : listeMarque) {
				insertMarque.setString(1, marque);
				insertMarque.executeUpdate();
			}
			ConnectionUtils.doCommit();
		} catch (SQLException e) {
			ConnectionUtils.doRollback();
			throw new TechnicalException("probleme d'insertion en base de données", e);
		} finally {
			if (insertMarque != null) {
				try {
					insertMarque.close();
				} catch (SQLException e) {
					throw new TechnicalException("impossible de fermer le preparedStatement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * récupère l'id d'une marque à partir de son nom
	 * 
	 * @param nom de la marque
	 * @return l'identifiant de la marque
	 */
	public Integer recupererIdMarque(String nom) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Integer id = null;

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select MRQ_ID from marque where MRQ_NOM=?");
			preparedStatement.setString(1, nom);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			if (resultSet.next()) {
				id = resultSet.getInt("MRQ_ID");
			}
			return id;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

	/**
	 * récupère la table marque et la stock dans une hashMap où le nom est la clé et
	 * l'identifiant la valeur
	 * 
	 * @return HashMap<String, Integer>
	 */
	public Map<Integer, String> recupererToutesMarques() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<Integer, String> listeMarque = new HashMap<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("SELECT MRQ_ID, MRQ_NOM FROM openfoodfactbdd.marque ORDER BY MRQ_NOM ASC;");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("MRQ_ID");
				String nom = resultSet.getString("MRQ_NOM");
				listeMarque.put(id, nom);
			}
			return listeMarque;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}
}
