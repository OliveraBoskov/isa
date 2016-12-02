package session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.FriendInvitation;

@Stateless
@Local(FriendInvitationDaoLocal.class)
public class FriendInvitationDaoBean extends GenericDaoBean<FriendInvitation, Integer> implements FriendInvitationDaoLocal {

}
